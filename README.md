# escape-plan
Harsh truths: You'll never be an L6

## Exercises
1. Implement division without using division operator:
    ```bash
    $ cd exercises
    $ kotlinc -script division-operator.kts -- <x> <y>
    $ kotlinc -script division-operator.kts -- 42 0
    Division_operator$DivZeroException: divided by zero
    $ kotlinc -script division-operator.kts -- 42 8
    42 / 8 = 5
    $ kotlinc -script division-operator.kts -- 42 -8
    42 / -8 = -5
    ```
