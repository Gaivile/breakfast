(ns breakfast-frontend.db)

#_(def default-db
  {:name "re-frame"})

(def default-db
  {
   :loading? false
   :error false
   :host {
          :name ""
          :date ""
          }
   })
