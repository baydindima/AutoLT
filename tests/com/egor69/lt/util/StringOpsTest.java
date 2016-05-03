package com.egor69.lt.util;

import org.junit.Test;

import static org.junit.Assert.*;

import static com.egor69.lt.util.StringOps.*;

public class StringOpsTest {

    @Test
    public void testRemoveInsipidSequences1() throws Exception {
        assertEquals("_", removeInsipidSequences("_(_(_<_[]>[][]{}))"));
    }

    @Test
    public void testRemoveInsipidSequences2() throws Exception {
        assertEquals("_(f(_))", removeInsipidSequences("_(f(_<_[]>[][]{}))"));
    }

    @Test
    public void testRemoveInsipidSequences3() throws Exception {
        assertEquals("_", removeInsipidSequences("_(_(_<_[]>[][]{_ _    _\n })   _   )"));
    }

    @Test
    public void testRemoveInsipidSequences4() throws Exception {
        assertEquals("q(_)", removeInsipidSequences("q(_(_<_[]>[][]{}))"));
    }

    @Test
    public void testRemoveInsipidSequences5() throws Exception {
        assertEquals("a._", removeInsipidSequences("a._()"));
    }

    @Test
    public void testRemoveInsipidSequences6() throws Exception {
        assertEquals("_", removeInsipidSequences("_._()"));
    }

    @Test
    public void testRemoveInsipidSequences7() throws Exception {
        assertEquals("_", removeInsipidSequences("_()._"));
    }

    @Test
    public void testRemoveInsipidSequences8() throws Exception {
        assertEquals("_.z", removeInsipidSequences("_().z"));
    }

    @Test
    public void testRemoveInsipidSequences9() throws Exception {
        assertEquals("_(1)._", removeInsipidSequences("_(1)._"));
    }

    @Test
    public void testRemoveInsipidSequences10() throws Exception {
        assertEquals("_(1)._", removeInsipidSequences("_(_(_<_[]>[][]{_ _    _\n  })   _   )(1)._._( _._ \n  )._(_(_<_[]>[][]{_ _    _\n  })   _   )"));
    }

    @Test
    public void testRemoveInsipidSequences11() throws Exception {
        assertEquals("_", removeInsipidSequences("_   ____  __  \n_\n_____"));
    }

    @Test
    public void testRemoveInsipidSequences12() throws Exception {
        assertEquals("_", removeInsipidSequences("_(_()._{})._"));
    }
}