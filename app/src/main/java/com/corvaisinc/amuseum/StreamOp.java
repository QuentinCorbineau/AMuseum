package com.corvaisinc.amuseum;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by quent on 20/11/2017.
 */

public class StreamOp {
    /**
     * @param in buffer with the php result
     * @param bufSize size of the buffer
     * @return the string corresponding to the buffer
     */
    public static String InputStreamToString (InputStream in,int bufSize) {
        final StringBuilder out = new StringBuilder();
        final byte[] buffer = new byte[bufSize];
        try {
            for (int ctr; (ctr = in.read(buffer)) != -1;) {
                out.append(new String(buffer, 0, ctr));
            }
        } catch (IOException e) {
            throw new RuntimeException("Cannot convert stream to string", e);
        }
        // returns the string with the data from the input stream
        return out.toString();
    }

    /**
     * @param in buffer with the php result
     * @return the string corresponding to the buffer
     */
    public static String InputStreamToString (InputStream in) {
        // call of the {@link #InputStreamToString(InputStream, int)} method with a default buffer size
        return InputStreamToString(in, 1024);
    }

}
