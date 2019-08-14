/*
 * Copyright 2019 Google LLC
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

package io.perfmark;

import javax.annotation.Nullable;

public abstract class Impl {

  protected static final String NO_TAG_NAME = null;
  protected static final long NO_TAG_ID = Long.MIN_VALUE;
  /**
   * This value is current {@link Long#MIN_VALUE}, but it could also be {@code 0}. The invariant
   * {@code NO_LINK_ID == -NO_LINK_ID} must be maintained to work when PerfMark is disabled.
   */
  protected static final long NO_LINK_ID = Long.MIN_VALUE;

  protected Impl(String password) {
    if (!"I'm pretty sure I know what I'm doing".equals(password)) {
      throw new AssertionError("You don't really know what you're doing.");
    }
  }

  protected abstract void setEnabled(boolean value);

  protected abstract void startTask(String taskName, @Nullable String tagName, long tagId);

  protected abstract void startTask(String taskName);

  protected abstract void event(String eventName, @Nullable String tagName, long tagId);

  protected abstract void event(String eventName);

  protected abstract void stopTask(String taskName, @Nullable String tagName, long tagId);

  protected abstract void stopTask(String taskName);

  protected abstract boolean shouldCreateTag();

  protected abstract long linkAndGetId();

  protected abstract void link(long linkId);
}
