(ns starter.components.search-content (:require [rum.core :as rum]
                                                [cljss.core :as css :refer [inject-global] :refer-macros [defstyles defkeyframes]]
                                                [cljss.rum :refer-macros [defstyled]]
                                                [starter.store.attributes :refer [attributes search-q]]
                                                [starter.theme :refer (colors)]))
;; CREATE SEARCH QUERY FROM ATTRIBUTE ITEMS
; 2d array of items
(rum/defcs search-attr < (rum/local true ::showing)
  [state attr items]
  (let [show-state (::showing state)]
    [:div {:key attr}
     [:h3 {:on-click (fn [_] (swap! show-state not))
           :css {:width "100%"
                 :margin-bottom "1.5em"
                 :&:hover {:cursor "pointer"}}}
      (get-in @attributes [attr :title])  (str @show-state)]
     [:div {:css {:width "100%"
                  :display (if @show-state "flex" "none")
                  :flex-wrap "wrap"
                  :justify-content "space-between"
                  :background-color (str "hsla( " (:ebonyClay colors) ", 0.5)")
                  :cljss.core/media {[[:max-width "777px"]] {:display (if @show-state "block" "none")}}}}
      (for [[name checked] items]
        [:div {:key name}
         (str  name checked)
         [:input {:type "checkbox" :name name :checked checked
                  :on-change (fn [e]
                               (swap! search-q assoc-in [attr name] (.. e -target -checked)))}]])]]))

(rum/defc search-content < rum/reactive []
  [:div {:css {:text-align "left"
               :margin-left "0em"
               :width "90vw"
               :height "67vh"
               :overflow "auto"
               :background-color (str "hsla( " (:ebonyClay colors) " , 0)")
               :color (str "hsl( " (:gallery colors) " )")}}
   (for [[attr items] (rum/react search-q)] (search-attr attr items))])
