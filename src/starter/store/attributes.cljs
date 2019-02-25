(ns starter.store.attributes)

(def attributes (atom
                 {:lf_arngmt
                  {:title "Leaf Arrangement"
                   :items
                   [{:name "alternate"
                     :description
                     "One leaf, branch, or flower part attaches at each point or node on the stem, and leaves  alternate direction, to a greater or lesser degree, along the stem."}
                    {:name "opposite"
                     :description
                     "Two leaves, branches, or flower parts attach at each point or node on the stem."}
                    {:name "whirled"
                     :description
                     "Three or more leaves, branches, or flower parts attach at each point or node on the stem."}
                    {:name "basal"
                     :description
                     "Arising from the base of the stem."}
                    {:name "none", :description ""}]}
                  :lf_shape
                  {:title "Leaf Shape"
                   :items
                   [{:name "ovate"
                     :description
                     "Oval, egg-shaped, with a tapering point and the widest portion near the petiole."}
                    {:name "lanceolate"
                     :description
                     "Long, wider in the middle, shaped like a lance tip."}
                    {:name "cordate"
                     :description
                     "Heart-shaped, with the petiole or stem attached to the notch."}
                    {:name "obovate"
                     :description
                     "Teardrop-shaped, stem attaches to the tapering end; reversed ovate."}
                    {:name "linear"
                     :description
                     "Long and very narrow like a blade of grass."}
                    {:name "needle"
                     :description
                     "Long and very narrow like a blade of grass."}]}
                  :lf_type
                  {:title "Leaf Type"
                   :items
                   [{:name "broadleaf", :description " "}
                    {:name "needles", :description " "}
                    {:name "frond", :description " "}
                    {:name "none", :description " "}]}
                  :form
                  {:title "Form"
                   :items
                   [{:name "grass", :description " "}
                    {:name "forb", :description " "}
                    {:name "tree", :description " "}
                    {:name "parasite", :description " "}]}
                  :lf_group
                  {:title "Leaf Group"
                   :items
                   [{:name "simple", :description " "}
                    {:name "compound palmate", :description " "}
                    {:name "compound pinnate", :description " "}
                    {:name "none", :description " "}]}
                  :habitat
                  {:title "Habitat"
                   :items
                   [{:name "mixed evergreen forest"
                     :description " "}
                    {:name "coastal prairie", :description " "}
                    {:name "grassland", :description " "}
                    {:name "chronically wet areas"
                     :description " "}
                    {:name "redwood forest", :description " "}
                    {:name "disturbed", :description " "}]}
                  :petals
                  {:title "Petals"
                   :items
                   [{:name "none", :description " "}
                    {:name "fused", :description " "}
                    {:name "three", :description " "}
                    {:name "five", :description " "}
                    {:name "six", :description " "}]}}))

(def attr-items  (map #(:items %) (vals @attributes)))
(defn get-names [items] (map #(:name %) items))
(def attr-items-names (map get-names attr-items))
(defn create-item-q [items] (zipmap (map keyword items) (repeat false)))
(def attr-items-q (map create-item-q attr-items-names))
(def search-q  (atom (zipmap (keys @attributes) attr-items-q)))
