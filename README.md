# Banking Transaction Management System — Java / Apache NetBeans

**Pearson BTEC Higher Nationals in Computing — Unit 19: Data Structures and Algorithms**

## Open in Apache NetBeans
1. Install **JDK 11 or newer**, **Apache NetBeans** (with Java/Maven support).
2. Unzip the project.
3. NetBeans → **File → Open Project** → choose `BankManagementNetBeans` (the folder containing `pom.xml`).
4. Right-click the project → **Run** (or run `mvn exec:java` in a terminal).
5. Demo staff login: username `staff`, password `Demo@123`.

## Features
- Java Swing desktop GUI: dashboard, accounts, transactions, VIP queue, activity log.
- Account creation, update, zero-balance closure, lookup by name or number.
- Deposit, withdrawal, transfer with amount and balance checks.
- Chronological transaction history and undo of most recent eligible operation.
- FIFO regular queue and VIP priority queue.
- Automatic serialized local persistence in `~/.bank-dsa-demo/bank-data.ser`.

## DSA evidence
| ADT / algorithm | Implementation | Purpose | Complexity |
|---|---|---|---|
| Map | `HashMap<String,Account>` | Account lookup by number | Expected O(1) |
| Linked list | `LinkedList<Transaction>` | Chronological history | Append O(1), search O(n) |
| Stack (LIFO) | `Stack<Long>` | Undo latest eligible transaction | Push/pop O(1), transaction search O(n) |
| Queue (FIFO) | `ArrayDeque<Request>` | Regular service requests | Add/poll O(1) amortized |
| Priority queue | `PriorityQueue<Request>` | VIP service before regular requests | Add/poll O(log n) |
| Sorting | `list.sort(Comparator...)` | Sort accounts by number | O(n log n) |
| Search | `HashMap.get`, name substring scan | Lookup by number/name | Expected O(1) / O(n) |

## Suggested test cases
1. Create an account with LKR 1000 opening deposit → account appears.
2. Deposit LKR 500 → balance increases to LKR 1500.
3. Withdraw LKR 200 → balance decreases to LKR 1300.
4. Attempt to withdraw LKR 999999 → rejected, balance unchanged.
5. Create second account, transfer LKR 300 → both balances updated.
6. Undo transfer → both balances restored, reversal logged.
7. Queue regular request A then B → FIFO A before B.
8. Queue VIP request C → VIP C served before regular requests.
9. Close an account with nonzero balance → rejected.
10. Close a zero-balance account → closed; transactions rejected.
11. Restart app → previously saved records reappear.
12. Search by name/number → matching accounts listed.

## Important limitations
This is a **coursework prototype, not a real banking system**. Login credentials are hardcoded and insecure for production; data is saved as a Java serialization file, not an audited transactional database; there is no multi-user locking, encryption at rest, role-based access control, tamper-proof audit trail, or regulatory compliance. Undo reverses the most recent eligible transaction only, subject to sufficient funds and active accounts. A transaction marked as reversed remains in history. Do not use for real customer funds or personal data.

## Assignment deliverables beyond this project
Your brief additionally requires a written report covering P1/P2/M1/M2/D1, P3/M2/D2, P4/P5/M4/D3 and P6/P7/M5/D4, including stack function-call diagrams, comparison of **two sorting algorithms**, analysis of **two shortest-path algorithms**, formal stack ADT specification, testing evidence, and complexity evaluation. This Java application alone does not satisfy all written criteria.

## Black & Gold UI update
- Gold bank logo bundled at src/main/resources/com/bankapp/bank-logo.png.
- Minimum opening deposit LKR 1,000 (enforced).
- Customer photo optional; selected image is resized and stored in local serialized data.
- VIP customer checkbox saved on account; queue requests for VIP accounts automatically receive priority.
- Existing deposit/withdraw/transfer actions remain immediate; priority applies to service queue ordering, not automatic transaction scheduling.
- All accounts are local coursework demo data; not a production banking system.


## Premium UI architecture (separate source files)
- `BankApp.java`: banking state, account/transaction operations and dashboard views (legacy coursework implementation).
- `LoginFrame.java`: full-screen branded login JFrame.
- `Theme.java`: shared black/gold Swing defaults.
- `CapsuleButtonUI.java`: rounded capsule-style Swing button painter.
- `src/main/resources/com/bankapp/bank-logo.png`: supplied gold bank emblem.

The account form supports an optional customer image, VIP checkbox and minimum LKR 1,000 opening deposit. The Priority Services queue serves VIP customers first; direct transaction actions do not wait in the service queue. This is a local coursework demonstration, not a production banking system.
