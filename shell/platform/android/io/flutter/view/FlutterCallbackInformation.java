// Copyright 2013 The Flutter Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

package io.flutter.view;

import androidx.annotation.Keep;
import io.flutter.embedding.engine.FlutterJNI;

/**
 * A class representing information for a callback registered using `PluginUtilities` from
 * `dart:ui`.
 */
@Keep
public final class FlutterCallbackInformation {
  public final String callbackName;
  public final String callbackClassName;
  public final String callbackLibraryPath;

  /**
   * Get callback information for a given handle.
   *
   * @param handle the handle for the callback, generated by `PluginUtilities.getCallbackHandle` in
   *     `dart:ui`.
   * @return an instance of FlutterCallbackInformation for the provided handle.
   */
  public static FlutterCallbackInformation lookupCallbackInformation(long handle) {
    return FlutterJNI.nativeLookupCallbackInformation(handle);
  }

  private FlutterCallbackInformation(
      String callbackName, String callbackClassName, String callbackLibraryPath) {
    this.callbackName = callbackName;
    this.callbackClassName = callbackClassName;
    this.callbackLibraryPath = callbackLibraryPath;
  }
}
