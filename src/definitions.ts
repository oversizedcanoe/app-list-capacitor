export interface AppListPlugin {
  echo(options: { value: string }): Promise<{ value: string }>;
  getInstalledApps() : Promise<AppInfo>;
}

export interface AppInfo {
  name: string;
}