## Avance del proyecto

### Fase 1: modelo de datos

En esta fase se elaboró el [diagrama entidad-relación](docs/ERDiagram.md) y se
actualizó el modelo JPA implementado en
`backend/src/main/java/com/example/wallettracker/model/`.

Las entidades principales del backend son:

- `User`: identifica al usuario y mantiene relaciones con `Categories`, `Balances`, `Transaction` y `Budget`.
- `Categories`: guarda las categorías creadas por cada usuario.
- `Balances`: representa cada origen de dinero del usuario, con `currency` (`CurrencyType`) y `balance_type` (`BalanceType`).
- `Transaction`: registra cada movimiento de ingreso o gasto, con `transaction_type` (`TransactionType`), `amount`, `transaction_date`, `balances`, `categories` y `user`.
- `Budget`: define el límite económico de una categoría para un usuario, con `limit_amount`, `start_date`, `end_date` y la relación con `category`.

La estructura sigue la lógica de un sistema de control de finanzas personal, donde cada usuario puede tener varias categorías, balances, transacciones y presupuestos.

## Configurar la contraseña de PostgreSQL en local

La aplicación lee la contraseña desde la variable de entorno `DB_PASSWORD`.
`.env.example` es solo una plantilla: Spring Boot no carga automáticamente los
archivos `.env`.

En PowerShell, define la variable en la misma terminal antes de iniciar el
backend:

```powershell
$env:DB_PASSWORD = "tu_contraseña_local"
cd backend
.\mvnw.cmd spring-boot:run
```

La variable solo queda definida en esa sesión de PowerShell. No guardes tu
contraseña real en `.env.example` ni la subas al repositorio.