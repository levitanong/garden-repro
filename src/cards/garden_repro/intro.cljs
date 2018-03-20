(ns garden-repro.intro
  (:require [devcards.core :as rc :refer-macros [defcard]]
            [garden-repro.ui.components :as comp]))

(defcard SVGPlaceholder
  "# SVG Placeholder"
  (comp/ui-placeholder {:w 200 :h 200}))
