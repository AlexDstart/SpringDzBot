package ru.skypro.lessons.springboot.weblibrary.controller.List;


    public record Employee(String name, int salary) {
        @Override
        public String toString() {
            return "{" +
                    "имя='" + name + '\'' +
                    ", зарплата=" + salary +
                    '}';
        }
    }

