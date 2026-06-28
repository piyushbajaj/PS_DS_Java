Problem #1: Passing Unnecessary Values

      Car car = new Car("V8", 4, 5, "Red", false, false); // The client needs to pass `false` for
      optional attributes

Problem #2: Constructor Overloading and Huge Combinations
* If a car has many optional attributes, you end up with multiple constructors, each for different combinations of parameters. This results in code duplication and leads to messy and unmanageable code.



