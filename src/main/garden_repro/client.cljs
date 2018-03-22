(ns garden-repro.client
  (:require
   [fulcro.client :as fc]
   [fulcro-css.css :as css]
   [garden-repro.ui.root :as root]
   [garden.core :as g]
   [fulcro.alpha.i18n :as i18n]
   yahoo.intl-messageformat-with-locales))

(defn message-format [{:keys [::i18n/localized-format-string ::i18n/locale ::i18n/format-options]}]
  (let [locale-str (name locale)
        formatter  (js/IntlMessageFormat. localized-format-string locale-str)]
    (.format formatter (clj->js format-options))))

(defonce app (atom nil))

(defn mount []
  (reset! app (fc/mount @app root/Root "app"))
  ;; fails
  (css/localize-css root/Root)
  ;; does not fail
  (css/get-local-rules root/Root)
  ;; Chances are that the problem lies in the specter call
  )

(defn start []
  (mount))

(defn ^:export init []
  (reset! app (fc/new-fulcro-client
                     :reconciler-options {:shared    {::i18n/message-formatter message-format}
                                          :shared-fn ::i18n/current-locale}))
  (start))
