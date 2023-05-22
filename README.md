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
* [`getInstalledApps(...)`](#getinstalledapps)
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


### getInstalledApps(...)

```typescript
getInstalledApps(queryParams: AppListQueryParams) => Promise<{ installedApps: AppInfo[]; }>
```

| Param             | Type                            |
| ----------------- | ------------------------------- |
| **`queryParams`** | <code>AppListQueryParams</code> |

**Returns:** <code>Promise&lt;{ installedApps: AppInfo[]; }&gt;</code>

--------------------


### Interfaces


#### AppInfo

| Prop                     | Type                 |
| ------------------------ | -------------------- |
| **`name`**               | <code>string</code>  |
| **`description`**        | <code>string</code>  |
| **`isSystemApp`**        | <code>boolean</code> |
| **`isUpdatedSystemApp`** | <code>boolean</code> |
| **`base64Icon`**         | <code>string</code>  |

</docgen-api>

