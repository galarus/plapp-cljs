(ns starter.core
  (:require [rum.core :as rum]
            [cljss.core :as css :refer [inject-global] :refer-macros [defstyles defkeyframes]]
            [cljss.rum :refer-macros [defstyled]]
            [starter.theme :refer (colors)]
            [starter.store.plants :refer (plants)]
            [starter.components.header :refer (plapp-header)]
            [starter.components.search-content :refer (search-content)]
            [starter.components.list-content :refer (list-content)]))


(inject-global
 {:body     {:margin 0
             :padding 0
             :font-family "Quicksand"
             :height "100%"
             :width "100vw"
             :overflow "hidden"}})



(def searching (atom true))

(rum/defc app < rum/reactive []
  [:div  {:css {:text-align "center"
                :height "100vh"
                :width "100%"
                :background-size "cover"
                :background-position "center"
                :background-color (str "hsl( " (:ships-officer colors) " )")
                :background-repeat "no-repeat"}}
   (plapp-header)
   [:div {:css {:position "absolute"
                :top "10%"
                :left "5%"}}
    (if (rum/react searching) (search-content) (list-content))
    [:button {:on-click  #(swap! searching not)} "toggle search" (str @searching)]]])

(defn stop []
  (js/console.log "Stopping..."))

(defn start []
  (js/console.log "Starting...")
  (rum/mount (app)
             (.getElementById js/document "app")))

(defn ^:export init []
  (start))
