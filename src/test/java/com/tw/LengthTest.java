package com.tw;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class LengthTest {
    @Test
    public void one_m_should_equal_another_one_m() throws Exception {
        Length oneM = new Length(1.0, "m");
        Length anotherOneM = new Length(1.0, "m");

        assertThat(oneM.equals(anotherOneM), is(true));
    }

    @Test
    public void one_m_should_not_equal_two_m() throws Exception {
        Length oneM = new Length(1.0, "m");
        Length twoMs = new Length(2.0, "m");

        assertThat(oneM.equals(twoMs), is(false));
    }

    @Test
    public void one_m_should_equal_hundred_cm() throws Exception {
        Length oneM = new Length(1.0, "m");
        Length hundredCM = new Length(100.0, "cm");

        assertThat(oneM.equals(hundredCM), is(true));
    }

    @Test
    public void hundred_cm_should_equal_one_m() throws Exception {
        Length hundredCM = new Length(100.0, "cm");
        Length oneM = new Length(1.0, "m");

        assertThat(hundredCM.equals(oneM), is(true));
    }

    @Test
    public void one_m_should_equal_thousand_mm() throws Exception {
        Length oneM = new Length(1.21, "m");
        Length hundredCM = new Length(1210.0, "mm");

        assertThat(oneM.equals(hundredCM), is(true));
    }

    @Test
    public void thousand_mm_should_equal_one_m() throws Exception {
        Length hundredCM = new Length(1000.0, "mm");
        Length oneM = new Length(1.0, "m");

        assertThat(hundredCM.equals(oneM), is(true));
    }

    @Test
    public void one_m_add_one_m_should_equal_two_m() throws Exception {
        Length oneM = new Length(1.0, "m");
        Length anotherOneM = new Length(1.0, "m");

        assertThat(oneM.add(anotherOneM).equals(new Length(2, "m")), is(true));
    }

    @Test
    public void ten_cm_add_one_m_should_equal_1100mm() throws Exception {
        Length one = new Length(1.0, "m");
        Length another = new Length(10, "cm");

        assertThat(one.add(another).equals(new Length(1100, "mm")), is(true));
    }

    @Test
    public void five_mm_subtract_one_mm_should_equal_four_mm() throws Exception {
        Length one = new Length(5, "mm");
        Length another = new Length(1, "mm");

        assertThat(one.subtract(another).equals(new Length(4, "mm")), is(true));
    }
}
