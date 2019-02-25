(ns starter.components.list-content  (:require [rum.core :as rum]
                                               [cljss.core :as css :refer [inject-global] :refer-macros [defstyles defkeyframes]]
                                               [cljss.rum :refer-macros [defstyled]]))

(rum/defc list-content [] [:div  "this is the search rts"])
