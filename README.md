# app-list-capacitor

A capacitor plugin to retrieve a list of apps installed on a device.

## Install

```bash
npm install app-list-capacitor
npx cap sync
```

## API

<docgen-index>

* [`echo(...)`](#echo)
* [`getInstalledApps()`](#getinstalledapps)
* [Interfaces](#interfaces)

</docgen-index>

<docgen-api>
<!--Update the source file JSDoc comments and rerun docgen to update the docs below-->

### echo(...)

```typescript
echo(options: { value: string; }) => Promise<{ value: string; }>
```

| Param         | Type                            |
| ------------- | ------------------------------- |
| **`options`** | <code>{ value: string; }</code> |

**Returns:** <code>Promise&lt;{ value: string; }&gt;</code>

--------------------


### getInstalledApps()

```typescript
getInstalledApps() => Promise<AppInfo>
```

**Returns:** <code>Promise&lt;<a href="#appinfo">AppInfo</a>&gt;</code>

--------------------


### Interfaces


#### AppInfo

| Prop       | Type                |
| ---------- | ------------------- |
| **`name`** | <code>string</code> |

</docgen-api>

