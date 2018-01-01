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

package com.moilioncircle.redis.replicator.cmd.impl;

import com.moilioncircle.redis.replicator.cmd.Command;

import java.util.Map;

/**
 * @author Leon Chen
 * @since 2.1.0
 */
public class MSetCommand implements Command {

    private static final long serialVersionUID = 1L;

    private Map<String, String> kv;
    private Map<byte[], byte[]> rawKv;

    public MSetCommand() {
    }

    public MSetCommand(Map<String, String> kv) {
        this(kv, null);
    }

    public MSetCommand(Map<String, String> kv, Map<byte[], byte[]> rawKv) {
        this.kv = kv;
        this.rawKv = rawKv;
    }

    public Map<String, String> getKv() {
        return kv;
    }

    public void setKv(Map<String, String> kv) {
        this.kv = kv;
    }

    public Map<byte[], byte[]> getRawKv() {
        return rawKv;
    }

    public void setRawKv(Map<byte[], byte[]> rawKv) {
        this.rawKv = rawKv;
    }

    @Override
    public String toString() {
        return "MSetCommand{" +
                "kv=" + kv +
                '}';
    }
}
