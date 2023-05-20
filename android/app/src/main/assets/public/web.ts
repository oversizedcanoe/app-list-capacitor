import { WebPlugin } from '@capacitor/core';

import type { AppInfo, AppListPlugin } from './definitions';

export class AppListWeb extends WebPlugin implements AppListPlugin {
  async echo(options: { value: string }): Promise<{ value: string }> {
    console.log('ECHO', options);
    return options;
  }

  async getInstalledApps(): Promise<AppInfo[]> {
      throw this.unimplemented('Not implemented on web')
  }
}
