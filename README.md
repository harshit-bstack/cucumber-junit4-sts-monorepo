# Cucumber JUnit 4 – Smart Test Selection demo (monorepo)

A small shop **app** and its **Cucumber JUnit 4 tests** in one repo, for trying BrowserStack
Smart Test Selection with `framework: cucumber-junit4`.

```
app/     shop domain code   (auth, catalog, cart, checkout)
tests/   cucumber-junit4 tests against the app
         ├─ AuthRunner  -> features/auth   (login, logout)       filesystem root
         └─ ShopRunner  -> features/shop   (search, cart, checkout) classpath: root
```

Two runners on purpose: the SDK makes **one** orchestration call covering both runners'
feature files, then each runner runs only its selected features.

## Run

```bash
export BROWSERSTACK_USERNAME=... BROWSERSTACK_ACCESS_KEY=...
# feature branch for the repo identifier used when generating test tags (no JSON needed)
export BROWSERSTACK_ORCHESTRATION_SMART_SELECTION_FEATURE_BRANCHES=SHOP:feature/cart-discount
mvn -q install -DskipTests          # builds app
cd tests && mvn test                # published SDK
cd tests && mvn test -Dsdk.jar=/abs/path/browserstack-java-sdk.jar   # local SDK build
```

## Try a selection

`main` is the baseline. Branch `feature/cart-discount` changes only `app/.../cart/Cart.java`
(a bulk discount), so a `relevantOnly` run on that branch should pick `cart.feature`
(and likely `checkout.feature`) and skip the auth features.
