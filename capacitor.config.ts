import { CapacitorConfig } from '@capacitor/cli';

const config: CapacitorConfig = {
  appId: 'com.oversizedcanoe.applist',
  appName: 'app-list-capacitor',
  webDir: 'src',
  server: {
    androidScheme: 'https'
  }
};

export default config;
