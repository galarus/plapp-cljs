(ns starter.components.header  (:require [rum.core :as rum]
                                         [cljss.core :as css :refer [inject-global] :refer-macros [defstyles defkeyframes]]
                                         [cljss.rum :refer-macros [defstyled]]))

(rum/defc plapp-header [] [:div {:css {:width "100%"
                                       :overflow "hidden"
                                       :height "3em"}} [:h2 {:css {:text-align "left"
                                                                   :color "#55E6C1"
                                                                   :margin "1%"
                                                                   :padding "0vh 5vw"}} "Pläpp"]])