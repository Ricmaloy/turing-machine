export type Step = {
  tapeValue?: string[];
  tapePosition?: number;
  actualState?: string;
  isAccepted?: boolean;
  transition?: boolean;
};
