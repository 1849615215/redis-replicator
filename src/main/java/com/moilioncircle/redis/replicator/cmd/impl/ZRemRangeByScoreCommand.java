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

/**
 * @author Leon Chen
 * @since 2.1.1
 */
public class ZRemRangeByScoreCommand implements Command {

    private static final long serialVersionUID = 1L;

    private String key;
    private String min;
    private String max;
    private byte[] rawKey;
    private byte[] rawMin;
    private byte[] rawMax;

    public ZRemRangeByScoreCommand() {
    }

    public ZRemRangeByScoreCommand(String key, String min, String max) {
        this(key, min, max, null, null, null);
    }

    public ZRemRangeByScoreCommand(String key, String min, String max, byte[] rawKey, byte[] rawMin, byte[] rawMax) {
        this.key = key;
        this.min = min;
        this.max = max;
        this.rawKey = rawKey;
        this.rawMin = rawMin;
        this.rawMax = rawMax;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getMin() {
        return min;
    }

    public void setMin(String min) {
        this.min = min;
    }

    public String getMax() {
        return max;
    }

    public void setMax(String max) {
        this.max = max;
    }

    public byte[] getRawKey() {
        return rawKey;
    }

    public void setRawKey(byte[] rawKey) {
        this.rawKey = rawKey;
    }

    public byte[] getRawMin() {
        return rawMin;
    }

    public void setRawMin(byte[] rawMin) {
        this.rawMin = rawMin;
    }

    public byte[] getRawMax() {
        return rawMax;
    }

    public void setRawMax(byte[] rawMax) {
        this.rawMax = rawMax;
    }

    @Override
    public String toString() {
        return "ZRemRangeByScoreCommand{" +
                "key='" + key + '\'' +
                ", min='" + min + '\'' +
                ", max='" + max + '\'' +
                '}';
    }
}
