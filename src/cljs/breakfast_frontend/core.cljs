(ns breakfast-frontend.core
    (:require [reagent.core :as reagent]
              [re-frame.core :as re-frame]
              [devtools.core :as devtools]
              [breakfast-frontend.handlers]
              [breakfast-frontend.subs]
              [breakfast-frontend.views :as views]
              [breakfast-frontend.config :as config]))


(defn dev-setup []
  (when config/debug?
    (enable-console-print!)
    (println "dev mode")
    (devtools/install!)))

(defn mount-root []
  (reagent/render [views/main-panel]
                  (.getElementById js/document "app")))

(defn ^:export init []
  (re-frame/dispatch-sync [:initialize-db])
  (re-frame/dispatch-sync [:fetch-rota])
  (dev-setup)
  (mount-root))
