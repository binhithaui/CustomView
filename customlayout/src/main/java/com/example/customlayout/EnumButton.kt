package com.example.customlayout

enum class EnumButton {
    BUTTON_1 {
        override fun toString(): String {
            return "1"
        }

        override fun getButton(): Int {
            return 1
        }

        override fun getType(): String {
            return "NUMBER"
        }
    },
    BUTTON_2 {
        override fun toString(): String {
            return "2"
        }

        override fun getButton(): Int {
            return 2
        }

        override fun getType(): String {
            return "NUMBER"
        }
    },
    BUTTON_3 {
        override fun toString(): String {
            return "3"
        }

        override fun getButton(): Int {
            return 3
        }

        override fun getType(): String {
            return "NUMBER"
        }
    },
    BUTTON_4 {
        override fun toString(): String {
            return "4"
        }

        override fun getButton(): Int {
            return 4
        }

        override fun getType(): String {
            return "NUMBER"
        }
    },
    BUTTON_5 {
        override fun toString(): String {
            return "5"
        }

        override fun getButton(): Int {
            return 5
        }

        override fun getType(): String {
            return "NUMBER"
        }
    },
    BUTTON_6 {
        override fun toString(): String {
            return "6"
        }

        override fun getButton(): Int {
            return 6
        }

        override fun getType(): String {
            return "NUMBER"
        }
    },
    BUTTON_7 {
        override fun toString(): String {
            return "7"
        }

        override fun getButton(): Int {
            return 7
        }

        override fun getType(): String {
            return "NUMBER"
        }
    },
    BUTTON_8 {
        override fun toString(): String {
            return "8"
        }

        override fun getButton(): Int {
            return 8
        }

        override fun getType(): String {
            return "NUMBER"
        }
    },
    BUTTON_9 {
        override fun toString(): String {
            return "9"
        }

        override fun getButton(): Int {
            return 9
        }

        override fun getType(): String {
            return "NUMBER"
        }
    },
    BUTTON_BACK {
        override fun toString(): String {
            return "BACK"
        }

        override fun getButton(): Int {
            return 10
        }

        override fun getType(): String {
            return "BACK"
        }
    },
    BUTTON_0 {
        override fun toString(): String {
            return "0"
        }

        override fun getButton(): Int {
            return 0
        }

        override fun getType(): String {
            return "NUMBER"
        }
    },
    BUTTON_CLEAR {
        override fun toString(): String {
            return "CLEAR"
        }

        override fun getButton(): Int {
            return 11
        }

        override fun getType(): String {
            return "BACK"
        }
    };

    open fun getButton(): Int = -1

    open fun getType(): String = ""
}