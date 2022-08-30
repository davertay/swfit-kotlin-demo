Pod::Spec.new do |s|
  s.name             = 'MyLogger'
  s.version          = '0.0.1'
  s.summary          = 'Kotlin Swift Logger'
  s.homepage         = 'https://github.com/davertay/swfit-kotlin-demo'
  s.license          = { :type => 'MIT', :file => 'LICENSE.md' }
  s.author           = { 'David Taylor' => 'davidtaylor@example.com' }
  s.source           = { :git => 'git@github.com:davertay/swfit-kotlin-demo.git', :tag => s.version.to_s }
  s.ios.deployment_target = '14.0'
  s.osx.deployment_target = '11.0'
  s.swift_version = '5.0'
  s.source_files = 'Sources/MyLogger/**/*.swift'
end
