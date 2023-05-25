# app-list-capacitor

A Capacitor plugin to retrieve a list of apps installed on a device. *Android only, at this time*.

Most of the below text is auto-generated, you can get this via npm straight from github as it's not hosted on npm.
``` bash
npm i https://github.com/oversizedcanoe/app-list-capacitor
npx cap sync
```

Follow the instructions as you would for any other Capacitor plugin.

To Do List:
- Return whatever is necessary to track when apps start/stop
- I'm not 100% clear on permissions in Android, I may need to check them each time despite existing in the Manifest
- Remove the boilerplate `echo` code
- Add more properties to the AppInfo class
- Implement IOS version
- Figure out a way to only return dummy web data if a certain method is called or certain parameter used?
  - It's convenient for testing but I'd prefer if it threw an exception unless you specifically requested dummy data.

# Auto Generated Text Below 👇

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

