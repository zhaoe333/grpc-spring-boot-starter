/*
 * Copyright 2016 Google, Inc.
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
 *
 */

package net.devh.springboot.autoconfigure.grpc.client;

import io.grpc.Channel;
import io.grpc.ManagedChannelBuilder;

/**
 * Created by rayt on 5/17/16.
 */
public class AddressChannelFactory implements GrpcChannelFactory {
    private final GrpcChannelsProperties channels;

    public AddressChannelFactory(GrpcChannelsProperties channels) {
        this.channels = channels;
    }

    @Override
    public Channel createChannel(String name) {
        GrpcChannelProperties channel = channels.getChannel(name);
        return ManagedChannelBuilder.forAddress(channel.getHost(), channel.getPort())
                .usePlaintext(channel.isPlaintext())
                .build();
    }
}
