/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */

package org.mozilla.gecko.util;

import org.mozilla.apache.commons.codec.binary.Base64;

import java.security.SecureRandom;

// Class copied from org.mozilla.gecko.sync.Utils b/c this module doesn't have access.
public class SyncUtils {

    private SyncUtils() {}

    private static final SecureRandom sharedSecureRandom = new SecureRandom();

    public static String generateGuid() {
        byte[] encodedBytes = Base64.encodeBase64(generateRandomBytes(9), false);
        return new String(encodedBytes, StringUtils.UTF_8).replace("+", "-").replace("/", "_");
    }

    /**
     * Helper to generate secure random bytes.
     *
     * @param length
     *        Number of bytes to generate.
     */
    public static byte[] generateRandomBytes(int length) {
        byte[] bytes = new byte[length];
        sharedSecureRandom.nextBytes(bytes);
        return bytes;
    }
}
