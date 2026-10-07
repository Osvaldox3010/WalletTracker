## Avance del proyecto

### Fase 1: modelo de datos

En esta fase se elaboró el [diagrama entidad-relación](docs/ERDiagram.md) y se
implementaron las entidades JPA del modelo en
`backend/src/main/java/com/example/wallettracker/model/`:

- `User`: usuarios y sus relaciones con categorías, balances, transacciones y presupuestos.
- `Categories`: categorías asociadas a un usuario.
- `Balances`: fuentes de dinero asociadas a un usuario y sus transacciones.
- `Transaction`: movimientos vinculados a un usuario, un balance y una categoría.
- `Budget`: presupuestos vinculados a un usuario y una categoría.

## Configurar la contraseña de PostgreSQL en local

La aplicación lee la contraseña desde la variable de entorno `DB_PASSWORD`.
`.env.example` es solo una plantilla: Spring Boot no carga automáticamente los
archivos `.env`.

En PowerShell, define la variable en la misma terminal antes de iniciar el
backend:

```powershell
$env:DB_PASSWORD = "tu_contraseña_local"
cd backend
mvn spring-boot:run
```

La variable solo queda definida en esa sesión de PowerShell. No guardes tu
contraseña real en `.env.example` ni la subas al repositorio.