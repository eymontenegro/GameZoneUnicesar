# AI Usage Log — Developer 1 (Products Module)

## [Date]
**Query:** Difference between association, composition and inheritance; when a class should be abstract.
**Use type:** Conceptual (OOP)
**How I used it:** Used this to confirm my understanding of why `Product` must be abstract before writing the class, and why `reduceStock()` should control state changes instead of using a plain setter.

## [Date]
**Query:** Suggestions for translating the class diagram's Spanish class/attribute/method names into English (e.g. Producto → Product, Videojuego → VideoGame).
**Use type:** English identifier naming suggestions
**How I used it:** Applied the suggested English names directly to my classes (`Product`, `VideoGame`, `Console`) to stay consistent with the team's translated diagrams.

## [Date]
**Query:** How to set up an existing Maven project in IntelliJ/NetBeans, and how to create packages and classes correctly nested under `com.gamezone`.
**Use type:** Tooling / Maven-specific how-to
**How I used it:** Followed the steps to open the project and fixed a mistake where I had created the `model` package outside `com.gamezone` by accident.

## [Date]
**Query:** Explanation of Git commands (`git checkout -b`, `git branch -m`, `git push --set-upstream`) and why empty folders aren't tracked by Git.
**Use type:** Git command explanation
**How I used it:** Used this to create and rename my `feature/product-module` branch correctly, and to fix a push error the first time I published my branch.

## [Date]
**Query:** Review of my own `Product`, `VideoGame`, and `Console` classes (compilation errors, typos, logic in `reduceStock()`).
**Use type:** Review of my own code
**How I used it:** Fixed a typo (`tittle` → `title`), an assignment-vs-comparison bug (`=` vs `<`), removed unnecessary setters not justified by the business context, and corrected direct access to a private inherited attribute (`title` → `getTitle()`).

## [Date]
**Query:** Explanation of the compiler error "VideoGame is not abstract and does not override abstract method describe()".
**Use type:** Compiler error explanation
**How I used it:** Understood that any concrete subclass of an abstract class must implement all its abstract methods, and added `describe()` to `VideoGame` to resolve it.

## [Date]
**Query:** Comparison of file persistence approaches available in Java (plain text, CSV, Java serialization, JSON) for the `ProductRepository` class.
**Use type:** How a specific Java/Maven functionality is implemented
**How I used it:** Used this comparison to decide, together with my own reasoning, to implement `ProductRepository` using CSV, prioritizing a human-readable file over less code.

## [Date]
**Query:** Difference between "Merge" and "Approve" on a GitHub Pull Request, and how to edit a PR description after creating it.
**Use type:** Git/GitHub workflow explanation
**How I used it:** Helped my team correctly complete the cross-review step required before merging my Pull Request into `develop`.
