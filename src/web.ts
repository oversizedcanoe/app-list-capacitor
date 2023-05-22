import { WebPlugin } from '@capacitor/core';
import { LoremIpsum } from "lorem-ipsum";
import { blackBase64, blueBase64, greenBase64, orangeBase64, pinkBase64, purpleBase64, redBase64, whiteBase64, yellowBase64 } from './really-long-strings'

import type { AppInfo, AppListPlugin, AppListQueryParams } from './definitions';

export class AppListWeb extends WebPlugin implements AppListPlugin {
  async echo(options: { value: string }): Promise<{ value: string }> {
    console.log('ECHO', options);
    return options;
  }

  async getInstalledApps(queryParams: AppListQueryParams): Promise<{installedApps: AppInfo[]}> {
    // In order to test functionality quickly (i.e. in Chrome instead of Android), return a few hard coded examples for web. Eventually, this should throw this.unimplemented
    //throw this.unimplemented('Not implemented on web')

    let apps: AppInfo[] = [];

    const nameLorem = new LoremIpsum({
      wordsPerSentence: {
        min: 1,
        max: 3
      }
    })

    const descriptionLorem = new LoremIpsum({
      wordsPerSentence: {
        min: 0,
        max: 10
      }
    })

    let base64Array: string[] = [];
    base64Array.push(blackBase64, blueBase64, greenBase64, orangeBase64, pinkBase64, purpleBase64, redBase64, whiteBase64, yellowBase64);


    for (let index = 0; index < 50; index++) {
      let app: AppInfo = new AppInfoWeb();
      app.name = nameLorem.generateSentences(1).replace('.', '');
      app.description = descriptionLorem.generateSentences(1);

      if (queryParams.includeIcons){
        let rand = Math.random();
        let randomIndex = Math.floor(rand*base64Array.length);
        app.base64Icon = base64Array[randomIndex];
      }

      apps.push(app);
    }

    let result: Promise<{installedApps: AppInfo[]}> = new Promise((resolve) => {
      resolve({installedApps: apps});
    });

    return result;
  }
}

class AppInfoWeb implements AppInfo {
  name: string = '';
  description: string  = '';
  isSystemApp: boolean = false;
  isUpdatedSystemApp: boolean = false;
  base64Icon: string = '';
}