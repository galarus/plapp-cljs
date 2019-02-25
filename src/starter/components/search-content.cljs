(ns starter.components.search-content (:require [rum.core :as rum]
                                                [cljss.core :as css :refer [inject-global] :refer-macros [defstyles defkeyframes]]
                                                [cljss.rum :refer-macros [defstyled]]
                                                [starter.store.attributes :refer (attributes)]
                                                [starter.theme :refer (colors)]))

;; CREATE SEARCH QUERY FROM ATTRIBUTE ITEMS
(def attr-items  (map #(:items %) (vals @attributes)))
(defn get-names [items] (map #(:name %) items))
(def attr-items-names (map get-names attr-items))
(defn create-item-q [items] (zipmap (map keyword items) (repeat false)))
(def attr-keys (keys @attributes))
(def attr-items-q (map create-item-q attr-items-names))
(def newq  (atom (zipmap attr-keys attr-items-q)))

(rum/defc search-content < rum/reactive []
  [:div {:css {:text-align "left"
               :margin-left "0em"
               :width "90vw"
               :height "67vh"
               :overflow "auto"
               :background-color (str "hsla( " (:ebonyClay colors) " , 0)")
               :color (str "hsl( " (:gallery colors) " )")}}
   (for [[attr items] (rum/react newq)] (search-attr attr items))])

(rum/defcs search-attr < (rum/local true ::showing)
  [state attr items]
  (let [show-state (::showing state)]
    [:div {:key attr}
     [:h3 {:on-click (fn [_] (swap! show-state not))} (get-in @attributes [attr :title])  (str @show-state)]
     (for [[name checked] items]
       [:div {:key name}
        (str  name checked)
        [:input {:type "checkbox" :name name :checked checked
                 :on-change (fn [e]
                              (swap! newq assoc-in [attr name] (.. e -target -checked)))}]])]))

