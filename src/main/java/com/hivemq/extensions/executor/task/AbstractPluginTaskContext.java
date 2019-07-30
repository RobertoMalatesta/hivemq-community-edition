/*
 * Copyright 2019 dc-square GmbH
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.hivemq.extensions.executor.task;


import com.hivemq.annotations.NotNull;

/**
 * Convenience class for creating the necessary runtime information for the handling of {@link PluginTask}s.
 *
 * @author Georg Held
 */
public abstract class AbstractPluginTaskContext implements PluginTaskContext {


    @NotNull
    private final Class<?> taskClazz;
    @NotNull
    private final String identifier;

    protected AbstractPluginTaskContext(@NotNull final Class<?> taskClazz, @NotNull final String identifier) {
        this.taskClazz = taskClazz;
        this.identifier = identifier;
    }

    @Override
    @NotNull
    public ClassLoader getPluginClassLoader() {
        return taskClazz.getClassLoader();
    }

    @Override
    @NotNull
    public String getIdentifier() {
        return identifier;
    }
}