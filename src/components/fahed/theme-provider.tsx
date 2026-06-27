'use client';

import { ThemeProvider as NextThemesProvider } from 'next-themes';
import { useEffect } from 'react';

export function ThemeProvider({ children }: { children: React.ReactNode }) {
  return (
    <NextThemesProvider attribute="class" defaultTheme="dark" enableSystem={false} storageKey="get-wallet-theme" disableTransitionOnChange>
      {children}
    </NextThemesProvider>
  );
}
