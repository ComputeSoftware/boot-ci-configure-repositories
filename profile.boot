(configure-repositories!
  (fn [{:keys [url] :as repo-map}]
      (->> (condp re-find url
                  (re-pattern (System/getenv "PRIVATE_MAVEN_URI"))
                  {:username (System/getenv "DEPS_API_KEY")
                   :password (System/getenv "DEPS_API_SECRET")}
                  #".*" nil)
           (merge repo-map))))