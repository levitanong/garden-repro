(ns garden-repro.ui.root
  (:require
   [fulcro.client.mutations :as m]
   [fulcro.client.data-fetch :as df]
   [fulcro.client.dom :as dom]
   [garden-repro.api.mutations :as api]
   [garden.units :refer [px]]
   [fulcro.client.primitives :as prim :refer [defsc]]
   [fulcro.alpha.i18n :as i18n :refer [tr trf]]))

;; The main UI of your application

(defsc Root
  [this props]
  {:css [[:.foo {:width (px 100)}]]}
  (dom/div nil "TODO"))
