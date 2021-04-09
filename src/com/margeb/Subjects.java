package com.margeb;

public enum Subjects {
    JAVA,
    PYTHON,
    C,
    CPP
            {
                @Override
                public String toString() {
                    return "C++";
                }
            },
    PASCAL,
    SPRING,
    MAVEN,
    DOCKER
}
