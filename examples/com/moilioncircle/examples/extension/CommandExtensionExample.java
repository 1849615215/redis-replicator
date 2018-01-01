/*
 * Copyright 2016-2018 Leon Chen
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.moilioncircle.examples.extension;

import com.moilioncircle.redis.replicator.RedisReplicator;
import com.moilioncircle.redis.replicator.Replicator;
import com.moilioncircle.redis.replicator.cmd.Command;
import com.moilioncircle.redis.replicator.cmd.CommandListener;
import com.moilioncircle.redis.replicator.cmd.CommandName;
import com.moilioncircle.redis.replicator.cmd.CommandParser;

import static java.nio.charset.StandardCharsets.UTF_8;

/**
 * @author Leon Chen
 * @since 2.1.0
 */
@SuppressWarnings("resource")
public class CommandExtensionExample {

    public static void main(String[] args) throws Exception {
        final Replicator replicator = new RedisReplicator("redis://127.0.0.1:6379");

        replicator.addCommandParser(CommandName.name("APPEND"), new YourAppendParser());

        replicator.addCommandListener(new CommandListener() {
            @Override
            public void handle(Replicator replicator, Command command) {
                if (command instanceof YourAppendParser.YourAppendCommand) {
                    YourAppendParser.YourAppendCommand yourAppendCommand = (YourAppendParser.YourAppendCommand) command;
                    System.out.println(yourAppendCommand.key);
                    System.out.println(yourAppendCommand.value);
                }
            }
        });
        replicator.open();
    }

    public static class YourAppendParser implements CommandParser<YourAppendParser.YourAppendCommand> {

        @Override
        public YourAppendCommand parse(Object[] command) {
            return new YourAppendCommand(new String((byte[]) command[1], UTF_8), new String((byte[]) command[2], UTF_8));
        }

        public static class YourAppendCommand implements Command {
            /**
             *
             */
            private static final long serialVersionUID = 1L;
            public final String key;
            public final String value;

            public YourAppendCommand(String key, String value) {
                this.key = key;
                this.value = value;
            }

            @Override
            public String toString() {
                return "YourAppendCommand{" +
                        "key='" + key + '\'' +
                        ", value='" + value + '\'' +
                        '}';
            }
        }
    }
}
