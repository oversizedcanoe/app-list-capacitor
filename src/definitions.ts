export interface AppListPlugin {
  echo(options: { value: string }): Promise<{ value: string }>;
  getInstalledApps(queryParams: AppListQueryParams) : Promise<{installedApps: AppInfo[]}>;
}

export interface AppInfo {
  name: string;
  description: string;
  isSystemApp: boolean;
  isUpdatedSystemApp: boolean;
  base64Icon: string;
}

export class AppListQueryParams {
  /**
   * When true, the plugin call will return system apps, such as carries services, demo mode, etc.
   * @default false
   */
  includeSystemApps: boolean = false;

  /**
   * When true, the plugin call will return updated system apps, meaning apps that came by default on the device but have been updated.
   * For example App Stores or default e-mail apps.
   * @default true
   */
  includeUpdatedSystemApps: boolean = true;

  /**
   * When true, the plugin call will return a base64 represenation of an app's icon. Otherwise an empty string will be returned.
   * @default true
  */
  includeIcons: boolean = true;
}