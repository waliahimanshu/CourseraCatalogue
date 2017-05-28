package com.waliahimanshu.courseracatalogue.ui.search;

class MyCustomType {
    private final Integer integer;
    private final String s;

    MyCustomType(Integer integer, String s) {

        this.integer = integer;
        this.s = s;
    }

    @Override
    public String toString() {
        return "MyCustomType{" +
                "integer=" + integer +
                ", s='" + s + '\'' +
                '}';
    }
}
