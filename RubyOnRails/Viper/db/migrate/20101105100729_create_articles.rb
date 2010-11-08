class CreateArticles < ActiveRecord::Migration
  def self.up
    create_table :articles do |t|
      t.string :title
      t.text :content

      t.timestamps
    end
    Article.create :title => "Cotard_delusion", :content => "'''The Cotard delusion''' or '''Cotard's syndrome''' or '''Walking Corpse Syndrome''' is a rare neuropsychiatric disorder in which people hold a delusional belief that they are [[dead]] (either figuratively or literally), do not exist, are putrefying, or have lost their [[blood]] or internal organs. In rare instances, it can include delusions of immortality."
    Article.create :title => "dead", :content => "Dead... Death... Punk is dead but hardcore lives. [[Converge]]  === Converge === ''These days, cowards outnumber the heroes, and the begging souls outweigh the calloused hands of the hardest of workers. Both in life and in art, the lack of passion is sickening, and the lust for complacency is poisonous. This album is the artistic antithesis of that sinking world; a thorn in the side of their beast. It's for those who move mountains one day at a time. It's for those who truly understand sacrifice. In our world of enemies, we will walk alone...''"
    Article.create :title => "blood", :content => "Blood is cool stuff... Try some blodpalt! Or die... [[dead|Corpses]] usually dont make use of their blood. Or make use of [[anything]] really."
    Article.create :title => "anything", :content => "Anything is not really anything but a very defined thing"
    Article.create :title => "Converge", :content => "Converge is an American band from Salem, Massachusetts. Playing a blend of hardcore punk and metal since 1990,  Converge has helped to define many of the elements of the metalcore genre... AND [[dead|DEATH]]!"
  end

  def self.down
    drop_table :articles
  end
end
