(def global-conf
  {:source-paths #{"src"}
   :resource-paths #{"resources" "generated-resources-browser"}
   :dependencies '[[com.hyperfiddle/hypercrud.browser "0.2.0-SNAPSHOT"]
                   [com.hyperfiddle/hypercrud.platform.browser "0.2.0-SNAPSHOT"]
                   [funcool/promesa "1.8.1"]
                   [org.clojure/clojurescript "1.9.946"]
                   [reagent "0.7.0" :exclusions [cljsjs/react cljsjs/react-dom cljsjs/react-dom-server cljsjs/create-react-class]]

                   ; build/test/dev
                   [adzerk/boot-cljs "2.1.4" :scope "test"]
                   [sparkfund/boot-lein-generate "0.3.0" :scope "test"]]})

(apply set-env! (mapcat identity global-conf))
(set-env! :boot.lein/project-clj global-conf)

(require '[adzerk.boot-cljs :refer :all]
         'boot.lein)

(task-options!
  pom {:project 'com.hyperfiddle.hello-world/runtime
       :version "0.1.0-SNAPSHOT"})

(deftask build [] (comp (cljs) (target)))

(when (> (.lastModified (clojure.java.io/file "build.boot"))
         (.lastModified (clojure.java.io/file "project.clj")))
  (boot.lein/write-project-clj))
