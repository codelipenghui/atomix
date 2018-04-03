/*
 * Copyright 2018-present Open Networking Foundation
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.atomix.primitive;

import io.atomix.utils.serializer.Serializer;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Primitive configuration.
 */
public class PrimitiveConfig<C extends PrimitiveConfig<C>> {
  private static final int DEFAULT_CACHE_SIZE = 1000;

  private Serializer serializer;
  private PrimitiveProtocol protocol;
  private boolean cacheEnabled = false;
  private int cacheSize = DEFAULT_CACHE_SIZE;
  private boolean readOnly = false;

  /**
   * Sets the serializer to use for transcoding info held in the primitive.
   *
   * @param serializer serializer
   * @return this configuration
   */
  @SuppressWarnings("unchecked")
  public C setSerializer(Serializer serializer) {
    this.serializer = serializer;
    return (C) this;
  }

  /**
   * Returns the serializer.
   *
   * @return the serializer
   */
  public Serializer getSerializer() {
    return serializer;
  }

  /**
   * Sets the primitive protocol.
   *
   * @param protocol the primitive protocol
   * @return the primitive configuration
   */
  @SuppressWarnings("unchecked")
  public C setProtocol(PrimitiveProtocol protocol) {
    this.protocol = checkNotNull(protocol, "protocol cannot be null");
    return (C) this;
  }

  /**
   * Returns the primitive protocol.
   *
   * @return the primitive protocol
   */
  public PrimitiveProtocol getProtocol() {
    return protocol;
  }

  /**
   * Enables caching for the primitive.
   *
   * @return the primitive configuration
   */
  public C setCacheEnabled() {
    return setCacheEnabled(true);
  }

  /**
   * Sets whether caching is enabled.
   *
   * @param cacheEnabled whether caching is enabled
   * @return the primitive configuration
   */
  @SuppressWarnings("unchecked")
  public C setCacheEnabled(boolean cacheEnabled) {
    this.cacheEnabled = cacheEnabled;
    return (C) this;
  }

  /**
   * Returns whether caching is enabled.
   *
   * @return whether caching is enabled
   */
  public boolean isCacheEnabled() {
    return cacheEnabled;
  }

  /**
   * Sets the cache size.
   *
   * @param cacheSize the cache size
   * @return the primitive configuration
   */
  @SuppressWarnings("unchecked")
  public C setCacheSize(int cacheSize) {
    this.cacheSize = cacheSize;
    return (C) this;
  }

  /**
   * Returns the cache size.
   *
   * @return the cache size
   */
  public int getCacheSize() {
    return cacheSize;
  }

  /**
   * Sets the primitive to read-only.
   *
   * @return the primitive configuration
   */
  public C setReadOnly() {
    return setReadOnly(true);
  }

  /**
   * Sets whether the primitive is read-only.
   *
   * @param readOnly whether the primitive is read-only
   * @return the primitive configuration
   */
  @SuppressWarnings("unchecked")
  public C setReadOnly(boolean readOnly) {
    this.readOnly = readOnly;
    return (C) this;
  }

  /**
   * Returns whether the primitive is read-only.
   *
   * @return whether the primitive is read-only
   */
  public boolean isReadOnly() {
    return readOnly;
  }
}
