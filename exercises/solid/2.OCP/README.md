This project contains an implementation of an OrderService with two packages:
* nl.oose.dea.orderservice.withoutocp contains classes and test cases without the OCP principle applied
* nl.oose.dea.orderservice.withocp contains some classes and test cases that guide you to apply the OCP

First read the sourcecode without OCP and run the test cases (comment the testcases with OCP applied to compile and run these testcases).
Second, read the test cases with OCP and (re)create the correct classes and interfaces so the unit tests all pass.

Refactor the code in the following order:
* EachPriceRule
* PerGramPriceRule
* SpecialPriceRule
* PricingCalculator and IPricingCalculator
* Cart