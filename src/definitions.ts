export interface AppListPlugin {
  echo(options: { value: string }): Promise<{ value: string }>;
  getInstalledApps() : Promise<{installedApps: AppInfo[]}>;
}

export interface AppInfo {
  name: string;
  description: string;
  isSystemApp: boolean;
  isUpdatedSystemApp: boolean;
  base64Icon: string;
}