package com.egor69.lt.util;

import java.util.List;

public final class ListOps {
    private ListOps() {}

    public static <T> boolean hasSubSequence(List<T> sequence, List<T> subSequence) {
        int iSeq = 0;
        int iSubSeq = 0;
        while (true) {
            if (sequence.size() - iSeq < subSequence.size() - iSubSeq) return false;
            if (iSubSeq == subSequence.size()) return true;
            if (sequence.get(iSeq).equals(subSequence.get(iSubSeq))) ++iSubSeq;
            ++iSeq;
        }
    }
}
