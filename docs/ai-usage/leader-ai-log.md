# AI Usage Log - Technical Leader (Sales & Integration Module)

**Project:** GameZoneUnicesar
**Developer:** Estefany Montenegro
**Role:** Project Coordinator & Backend Developer - Sales Module, UI Layer, and System Integration
**Assigned Branch:** develop / feature/sale-module
**File Location:** docs/ai-usage/leader-ai-log.md

## 📑 Module Responsibilities Summary

- Project structure setup, Git Flow configuration, and branch protections (main, develop).
- Implementation of the Sale domain class and calculation of the sale total.
- Implementation of SaleRepository for CSV-based persistence (data/sales.csv, data/sale_details.csv).
- Implementation of SaleService coordinating cross-module business logic (stock verification, inventory updates via ProductService).
- Implementation of the ui layer (ConsoleMenu) and coordination of the entry point (Main.java).
- Coordination of Pull Request creation and cross-review process across the three modules.

## 📌 Detailed AI Interaction Records

### Session 1: Git Flow setup and branch protection

**Prompt / Query Asked to AI:** How to configure the initial repository, protect `main` and `develop`, and set up the four-layer Maven package structure correctly in NetBeans.

**Context & Problem:** Needed to understand the correct sequence for creating the GitHub repository, cloning it, creating `develop` from `main`, and structuring the Maven project without duplicating folders.

**AI Response Summary:** Provided step-by-step guidance for repository creation, branch protection settings, and resolving a NetBeans issue where the Maven project was created in a nested folder.

**Developer Action & Validation:** Completed the setup, verified with `git status` and by checking the repository structure on GitHub, and pushed the configuration through a Pull Request reviewed by a teammate.

### Session 2: Confirming responsibility placement for stock validation

**Prompt / Query Asked to AI:** Reviewed why the stock-reduction logic inside `Sale.confirm()` did not match the team's own answer to question 8 of `docs/analysis.md`.

**Context & Problem:** The first version of `Sale.confirm()` reduced product stock directly, contradicting the team's own documented decision that this responsibility belongs to `SaleService`.

**AI Response Summary:** Pointed out the contradiction with the already-approved `docs/analysis.md` answer and asked guiding questions to identify which part of the logic belonged in `Sale` versus `SaleService`, without supplying the corrected code directly.

**Developer Action & Validation:** Moved the stock-reduction loop out of `Sale.confirm()` and implemented it later in `SaleService.registerSale()`, coordinating with `ProductService.updateStock()`.

### Session 3: Reviewing SaleService coordination logic

**Prompt / Query Asked to AI:** Shared the self-written `SaleService` class for review after implementing it independently.

**Context & Problem:** Needed to confirm that the stock-validation-before-reduction approach and the order of operations (validate → create Sale → confirm → reduce stock → persist) were sound.

**AI Response Summary:** Confirmed the logic was correct, highlighted the benefit of validating all items before reducing any stock, and raised a conceptual question about the order between `sale.confirm()` and stock reduction for the developer to reason through.

**Developer Action & Validation:** Reviewed the reasoning and decided to keep the original order, understanding the trade-off for this system's scope.

### Session 4: Reviewing the ConsoleMenu class against workshop requirements

**Prompt / Query Asked to AI:** Shared the `ConsoleMenu` class (built by a teammate) for review before merging it into the sales/integration branch.

**Context & Problem:** Needed to confirm the UI class complied with the workshop's layer-access restrictions and did not duplicate the application's entry point.

**AI Response Summary:** Identified that the class had its own `main()` method duplicating `Main.java`, and that the workshop requires submenus per module (activity 10 for the Technical Leader), which the current single-class design did not reflect.

**Developer Action & Validation:** Pending — reorganizing the UI layer into a main menu plus submenus per module, and updating `docs/layers-diagram.md` accordingly.

## 🛡️ Ethics & Compliance Declaration

**Self-Comprehension:** All domain classes (`Sale`, `SaleDetail`), the repository (`SaleRepository`), and the service (`SaleService`) were written independently before being submitted to the AI for review.

**Academic Integrity:** The AI was used exclusively for Git/GitHub workflow guidance, conceptual clarification of OOP and layered architecture principles, and review of already-written code against the team's own analysis documents — never to generate the design, answer the analysis questions, or implement complete classes, per the workshop's AI usage policy (sections 16 and 17).
