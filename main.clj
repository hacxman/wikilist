(require '[clojure.xml :as xml]
         '[clojure.walk :as walk])

; {}
(def empty-item {:url nil,
                 :user nil,
                 :count nil,
                 :category nil,
                 :name nil,
                 :price nil})

(defn show-item "show's shoplist item"
  [item]
  (str (:name item) " "
       (:count item) " "
       (:price item) " "
       (:url item) " "
       (:user item) " "
       (:category item) " "))

(defn serialize-item "show's shoplist item"
  [item]
  (str "| " (:name item) "\n"
       "| " (:url item) "\n"
       "| " (:count item) "\n"
       "| " (:price item) " CZK\n"
       "| [[User:" (:user item) "]]\n"
       "| " (:category item) "\n"))

(defn deserialize-item [])

(def empty-shoplist [])
(defn show-shoplist [list]
  (concat (map #(show-item %1) list)))


;(println (show-item {:url "bla", :user "hexo", :count 6, :category "kokot", :name "basf", :price 3204}))
;(println (serialize-item {:url "bla", :user "hexo", :count 6, :category "kokot", :name "basf", :price 3204}))

(defn get-tag-content
  [input tag]
  (filter
    (fn [x] (do
              (println tag)
              (println (:tag x ))
              (= (:tag x) (keyword tag))))
    input))

(defn extract-textarea
  [input]
  (do
    (println (get input :tag))
    (println (get-tag-content [input] "html")))
)

;(println (xml/parse "http://wiki.base48.cz/index.php?title=Farnell&action=edit"))
(println (extract-textarea (xml/parse "http://wiki.base48.cz/index.php?title=Farnell&action=edit")))

