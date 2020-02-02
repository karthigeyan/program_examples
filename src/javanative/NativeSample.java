package javanative;

import java.lang.annotation.Annotation;
import java.lang.annotation.Native;

public class NativeSample implements Native{
    public static void main(String[] args) {
    }

    @Override
    public Class<? extends Annotation> annotationType() {
        return null;
    }
}