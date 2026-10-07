```mermaid
erDiagram
    USERS {
        BIGINT user_id PK
        VARCHAR name "NOT NULL, 20"
        VARCHAR lastName "40"
    }

    CATEGORIES {
        BIGINT id_category PK
        VARCHAR name "NOT NULL, 20"
        VARCHAR description "40"
        BIGINT user_id FK "NOT NULL"
    }

    BALANCES {
        BIGINT id_balance PK
        VARCHAR source UK "NOT NULL, 20"
        VARCHAR description "NOT NULL, 40"
        VARCHAR currency "ENUM: USD, EUR, GBP, JPY"
        VARCHAR balance_type "ENUM: CASH, BANK, CREDIT_CARD"
        NUMERIC balance "NOT NULL, 10, 2"
        BIGINT user_id FK "NOT NULL"
    }

    TRANSACTIONS {
        BIGINT id_transaction PK
        VARCHAR name "NOT NULL, 20"
        VARCHAR description "40"
        VARCHAR transaction_type "ENUM: INCOME, EXPENSE"
        NUMERIC amount "NOT NULL, 10, 2"
        TIMESTAMP transaction_date "NOT NULL"
        BIGINT id_balance FK "NOT NULL"
        BIGINT id_category FK "NOT NULL"
        BIGINT user_id FK "NOT NULL"
    }

    BUDGETS {
        BIGINT id_budget PK
        NUMERIC limit_amount "NOT NULL, 10, 2"
        DATE start_date "NOT NULL"
        DATE end_date "NOT NULL"
        BIGINT user_id FK "NOT NULL"
        BIGINT id_category FK "NOT NULL"
    }

    USERS ||--o{ CATEGORIES : tiene
    USERS ||--o{ BALANCES : tiene
    USERS ||--o{ TRANSACTIONS : realiza
    USERS ||--o{ BUDGETS : define
    CATEGORIES ||--o{ TRANSACTIONS : clasifica
    CATEGORIES ||--o{ BUDGETS : limita
    BALANCES ||--o{ TRANSACTIONS : registra
```

El modelo actual del backend corresponde a las entidades JPA `User`, `Categories`, `Balances`, `Transaction` y `Budget`:

- `User` representa a cada usuario y se relaciona con todas sus categorías, balances, transacciones y presupuestos.
- `Categories` almacena categorías creadas por un usuario.
- `Balances` representa una fuente de dinero con tipo de moneda y tipo de saldo.
- `Transaction` registra ingresos o gastos asociados a un balance, una categoría y un usuario.
- `Budget` define un límite mensual o previo por categoría y usuario.

